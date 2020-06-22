package com.homolangma.ThreadLocalSimpleTest.v2;

/**
 * @author: Mr.Harry
 * @date : 2020/5/21 23:01
 * @title :
 */
public class Context {
    private String name;

    public String getCardId() {
        return cardId;
    }

    private String cardId;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "Context{" +
                "name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }

}
