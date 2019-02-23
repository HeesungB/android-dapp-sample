package info.panicrooms.dapp_sample;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import info.panicrooms.dapp_sample.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    ActivityMainBinding mainBinding;

    Web3j web3;
    Credentials credentials;
    Mail mail;

    ArrayList<MailBody> myMailList;
    MailListAdapter mailListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setMainLayout(this);

        getSupportActionBar().setTitle("Mail List");

        web3 = Web3j.build(new HttpService("http://172.30.1.16:8545"));
        credentials = Credentials.create("0x8aefa2bff25f39587176923d591ad637c5490e591c8858df71f2fc6dd7368d18");

        BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
        BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

        mail = new Mail("0x46456a5B9221C4433A87b1836f15443d30123413",web3,credentials,GAS_PRICE,GAS_LIMIT);

        myMailList = new ArrayList<>();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mainBinding.mailList.setLayoutManager(llm);

        mainBinding.mailList.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

        mailListAdapter = new MailListAdapter(MainActivity.this, myMailList);
        mainBinding.mailList.setAdapter(mailListAdapter);

        mainBinding.mailList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {
                View ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {
                    String senderAddress = (String) ChildView.getTag();

                    ClipboardManager clipboardManager = (ClipboardManager)MainActivity.this.getSystemService(MainActivity.this.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("label", senderAddress);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(MainActivity.this, "Copy Sender Address", Toast.LENGTH_SHORT).show();


                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {}

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
        });


        mainBinding.swipeLayout.setOnRefreshListener(this);

    }

    @Override
    public void onRefresh() {

        Web3AsyncTask asyncTask = new Web3AsyncTask();
        asyncTask.execute();

        mainBinding.swipeLayout.setRefreshing(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Web3AsyncTask asyncTask = new Web3AsyncTask();
        asyncTask.execute();
    }

    public class Web3AsyncTask extends AsyncTask<String,Void,String>{

        public String result;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                myMailList.clear();

                List<BigInteger> mailList = mail.getReceiveMailBox().sendAsync().get();
                Collections.reverse(mailList);

                for(int i=0; i<mailList.size(); i++){
                    Tuple2<String, String> getMailList = mail.getMailContent(mailList.get(i)).sendAsync().get();

                    MailBody tempMailBody = new MailBody(
                            getMailList.getValue1(),
                            getMailList.getValue2()
                    );

                    myMailList.add(tempMailBody);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


            return result;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mailListAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(MainActivity.this, SendMailActivity.class);
                startActivity(intent);
                return(true);
        }

        return(super.onOptionsItemSelected(item));
    }
}
