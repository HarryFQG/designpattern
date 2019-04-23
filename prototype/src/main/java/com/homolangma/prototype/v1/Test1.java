package com.homolangma.prototype.v1;

/**
 * @author 36732
 * @date 2019/4/14 19:52
 */
public class Test1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        for (int i = 0; i < 10; i++) {
            Mail mailTemp= (Mail) mail.clone();
            mailTemp.setName("张三-"+i);
            mailTemp.setEmailAddress("zhangsan-"+i+"-@qq.com");
            mailTemp.setContent("马尔扎哈，哔哩哔哩。");
            MailUtil.sendMail(mailTemp);
        }
        MailUtil.saveOriginMailRecord(mail);

    }

}
