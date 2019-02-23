package info.panicrooms.dapp_sample;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import info.panicrooms.dapp_sample.databinding.ActivitySendmailBinding;

public class SendMailActivity extends AppCompatActivity {
    ActivitySendmailBinding sendmailBinding;

    Web3j web3;
    Credentials credentials;
    Mail mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sendmailBinding = DataBindingUtil.setContentView(this, R.layout.activity_sendmail);
        sendmailBinding.setSendMailLayout(this);

        getSupportActionBar().setTitle("Send Mail"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        web3 = Web3j.build(new HttpService("http://172.30.1.16:8545"));
        credentials = Credentials.create("0x8aefa2bff25f39587176923d591ad637c5490e591c8858df71f2fc6dd7368d18");

        BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
        BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

        mail = new Mail("0x46456a5B9221C4433A87b1836f15443d30123413",web3,credentials,GAS_PRICE,GAS_LIMIT);


        sendmailBinding.mailCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sendmailBinding.mailSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MailBody tempMailBody = new MailBody(
                        sendmailBinding.mailSender.getText().toString(),
                        sendmailBinding.mailContent.getText().toString()
                );

                Web3AsyncTask asyncTask = new Web3AsyncTask(tempMailBody);
                asyncTask.execute();
            }
        });

    }

    public class Web3AsyncTask extends AsyncTask<String ,Void,String> {

        public MailBody mailBody;
        public String result;

        public Web3AsyncTask(MailBody mailBody){
            this.mailBody = mailBody;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                mail.sendMail(mailBody.getMailSender(),mailBody.getMailContent()).send();
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
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
