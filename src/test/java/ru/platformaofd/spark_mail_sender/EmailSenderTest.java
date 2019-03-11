package ru.platformaofd.spark_mail_sender;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailSenderTest {

    @Test
    @Ignore
    public void sendEmail() {
        EmailSender sender = new EmailSender();
        sender.sendEmail("a.burlaka@platformaofd.ru", "test subject");
    }
}