#!/bin/bash

echo "ls build"
ls build

echo "ls build/distributions"
ls build/distributions

aws lambda update-function-code \
--zip-file=fileb://build/distributions/twitter-1.0-SNAPSHOT.zip \
--region=eu-central-1 \
--function-name=TweetsCounter

