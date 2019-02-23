package info.panicrooms.dapp_sample;

public class MailBody {
    String mailSender;
    String mailContent;

    public MailBody(String mailSender, String mailContent) {
        this.mailSender = mailSender;
        this.mailContent = mailContent;
    }

    public String getMailSender() {
        return mailSender;
    }

    public void setMailSender(String mailSender) {
        this.mailSender = mailSender;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
}
