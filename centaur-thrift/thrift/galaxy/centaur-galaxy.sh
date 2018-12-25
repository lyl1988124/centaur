#!/usr/bin/env bash

source ././../../copy_folder.sh

thrift --gen java  ././../common/Common.thrift

thrift --gen java galaxy.thrift

copy_folder ./gen-java/com/lyl/thrift/common/ ./../../../centaur-thrift/src/main/java/com/lyl/thrift/common/
copy_folder ./gen-java/com/lyl/thrift/galaxy/ ./../../../centaur-thrift/src/main/java/com/lyl/thrift/galaxy/