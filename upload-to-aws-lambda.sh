#!/bin/bash
aws lambda update-function-code \
--zip-file=fileb://build/distributions/twitter-metric-sl-1.0-SNAPSHOT.zip \
--region=eu-central-1 \
--function-name=TweetsCounter

