#!/bin/bash
aws lambda update-function-code \
--zip-file=fileb://build/distributions/twitter-metric-sl-1.0-SNAPSHOT.zip \
--region=eu-central-1 \
--function-name=TweetsCounter \


aws lambda update-function-configuration \
--function-name=TweetsCounter \
--environment '{"Variables":{"CONSUMER_KEY":"$CONSUMER_KEY", "CONSUMER_SECRET":"$CONSUMER_SECRET”, "ACCESS_TOKEN":”$ACCESS_TOKEN”, "ACCESS_TOKEN_SECRET":”$ACCESS_TOKEN_SECRET”}}'

