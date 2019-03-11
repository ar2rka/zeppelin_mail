package ru.platformaofd.spark_mail_sender;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final EmailSender sender = new EmailSender();
        final String address = args[0];
        final String subject = args[1];
        sender.sendEmail(address, subject);
    }
}
