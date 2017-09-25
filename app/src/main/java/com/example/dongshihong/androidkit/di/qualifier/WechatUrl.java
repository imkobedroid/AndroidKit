package com.example.dongshihong.androidkit.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author keal
 *         Created  on 2017/05/03 11:56.
 *         Summary:
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface WechatUrl {

}