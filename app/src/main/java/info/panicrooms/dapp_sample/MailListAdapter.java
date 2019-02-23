package info.panicrooms.dapp_sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MailListAdapter extends RecyclerView.Adapter<MailListAdapter.MailListView> {

    ArrayList<MailBody> mailList;
    private Context context;

    public MailListAdapter(Context context, ArrayList<MailBody> mailList) {
        this.context = context;
        this.mailList = mailList;
    }

    public class MailListView extends RecyclerView.ViewHolder {
        public LinearLayout mailLayout;
        public TextView mailSender;
        public TextView mailContent;

        public MailListView(View view) {
            super(view);
            mailLayout = (LinearLayout)view.findViewById(R.id.mailLayout);
            mailSender = (TextView) view.findViewById(R.id.mailSender);
            mailContent = (TextView)view.findViewById(R.id.mailContent);
        }
    }

    @Override
    public MailListView onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mail_list, parent, false);
        return new MailListView(itemView);
    }

    @Override
    public void onBindViewHolder(final MailListView holder, final int position) {
        MailBody mailBody = mailList.get(position);
        holder.mailSender.setText(mailBody.getMailSender());
        holder.mailContent.setText(mailBody.getMailContent());

        holder.mailLayout.setTag(mailBody.mailSender);

    }

    @Override
    public int getItemCount() {
        return mailList.size();
    }
}
