package com.dexterv;

import com.dexterv.learn.collections.CollectionsPlayground;
import com.dexterv.learn.streams.StreamsPlayground;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n___________________STREAMS____________________\n");
        StreamsPlayground learnStream = new StreamsPlayground();
        learnStream.nameStream();
        learnStream.wordFrequency();

        System.out.println("\n___________________COLLECTIONS____________________\n");

        CollectionsPlayground learnCollection = new CollectionsPlayground();
        learnCollection.employeeData();

    }
}