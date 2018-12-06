#!/bin/bash
#数据库相关信息
HOSTNAME="127.0.0.1"
PORT="3306"
USERNAME="test"
PASSWORD="test"
DB_NAME="test"

MYSQL_CMD="mysql -h${HOSTNAME}  -P${PORT}  -u${USERNAME} -p${PASSWORD}"

#创建数据库
#create_db_sql="drop  database ${DB_NAME}; create database IF NOT EXISTS ${DB_NAME};"
`$MYSQL_CMD  -e "use ${DB_NAME};"`

echo "" > inDB.sql
# 生成建表语句
generateTables() {
    startIndex=0   #开始序号
    endIndex=10  #结束序号
    while [ ${startIndex} -le ${endIndex} ]
    do
        TABLE_NAME="$2_${startIndex}"
        sql=`cat $1`
        #导出sql文件
        echo ${sql/$2/$TABLE_NAME} >> inDB.sql
        if [ $? -ne 0 ] #判断是否创建成功
        then
            echo $?
            echo "generate table ${TABLE_NAME} sql fail ..."
            exit 1
        else
            echo "generate table ${TABLE_NAME} sql success ..."
        fi
        startIndex=`expr ${startIndex} + 1`
    done
}

generateTables sql/test.sql test;