package com.example.recipeappmvp.util;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide.RequestOptionsFactory;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;

public class MyAppGlideModule extends AppGlideModule {

  @Override
  public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
    super.applyOptions(context, builder);
    RequestOptions requestOptions = new RequestOptions();
    requestOptions.format(DecodeFormat.PREFER_RGB_565);
    requestOptions.disallowHardwareConfig();
    builder.setDefaultRequestOptions(requestOptions);
    builder.setDiskCache(new InternalCacheDiskCacheFactory(context));
  }
}
