#!/usr/bin/env bash

source ././../../copy_folder.sh

thrift --gen java Common.thrift

copy_folder ./gen-java/com/lyl/thrift/common/ ./../../../centaur-thrift/src/main/java/com/lyl/thrift/common/