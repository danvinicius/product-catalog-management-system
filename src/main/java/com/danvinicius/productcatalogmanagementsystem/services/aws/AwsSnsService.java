package com.danvinicius.productcatalogmanagementsystem.services.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;

@Service
public class AwsSnsService {
    @Autowired
    private AmazonSNS snsClient;

    @Autowired
    @Qualifier("catalogEventsTopic")
    private Topic catalogTopic;

    public void publish(MessageDTO message) {
        this.snsClient.publish(catalogTopic.getTopicArn(), message.message());
    }
}
