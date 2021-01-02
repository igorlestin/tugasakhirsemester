#include <jni.h>

extern "C"
JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_igorlestin_jadwalin_CalculatorActivity_calculateTarget(
        JNIEnv *env, jobject thiz, jint weight) {
        jlong watereach = 2;
        return weight * watereach;
}