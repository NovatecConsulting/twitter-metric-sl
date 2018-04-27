#!/bin/bash

ls
tree
pwd

aws lambda update-function-code \
--zip-file=fileb://build/distributions/twitter-1.0-SNAPSHOT.zip \
--region=eu-central-1 \
--function-name=TweetsCounter

