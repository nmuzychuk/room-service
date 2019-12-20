#!/usr/bin/env bash

TMP_PATH=tmp
ROOM_COMMON=room-common
ROOM_COMMON_REPO_URL=https://github.com/nmuzychuk/${ROOM_COMMON}.git

mkdir -p ${TMP_PATH}
pushd ${TMP_PATH}
git clone ${ROOM_COMMON_REPO_URL}
pushd ${ROOM_COMMON}
mvn clean install
popd
popd
