//
// Created by sunhuaxiao on 2019-06-10.
//

#include "native-lib.h"
#include <string>
#include <jni.h>

//extern "C"
//JNIEXPORT jstring
//
//JNICALL
//Java_NDKTools_getStringFromNDK(
//        JNIEnv *env, jobject /* this */) {
//    std::string hello = "hello world";
//    return env->NewStringUTF(hello.c_str());
//}

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_huaxiao_demo_jni_NDKTools_getStringFromNDK(JNIEnv *env, jclass type) {
    std::string hello = "hello world";
    return env->NewStringUTF(hello.c_str());
}