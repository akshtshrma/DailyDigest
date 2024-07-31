package com.androiddevs.mvvmnewsapp.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.androiddevs.mvvmnewsapp.models.Article
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ArticlePreviewFragmentArgs(
  public val article: Article,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Article::class.java)) {
      result.putParcelable("article", this.article as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Article::class.java)) {
      result.putSerializable("article", this.article as Serializable)
    } else {
      throw UnsupportedOperationException(Article::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Article::class.java)) {
      result.set("article", this.article as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Article::class.java)) {
      result.set("article", this.article as Serializable)
    } else {
      throw UnsupportedOperationException(Article::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): ArticlePreviewFragmentArgs {
      bundle.setClassLoader(ArticlePreviewFragmentArgs::class.java.classLoader)
      val __article : Article?
      if (bundle.containsKey("article")) {
        if (Parcelable::class.java.isAssignableFrom(Article::class.java) ||
            Serializable::class.java.isAssignableFrom(Article::class.java)) {
          __article = bundle.get("article") as Article?
        } else {
          throw UnsupportedOperationException(Article::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__article == null) {
          throw IllegalArgumentException("Argument \"article\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"article\" is missing and does not have an android:defaultValue")
      }
      return ArticlePreviewFragmentArgs(__article)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        ArticlePreviewFragmentArgs {
      val __article : Article?
      if (savedStateHandle.contains("article")) {
        if (Parcelable::class.java.isAssignableFrom(Article::class.java) ||
            Serializable::class.java.isAssignableFrom(Article::class.java)) {
          __article = savedStateHandle.get<Article?>("article")
        } else {
          throw UnsupportedOperationException(Article::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__article == null) {
          throw IllegalArgumentException("Argument \"article\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"article\" is missing and does not have an android:defaultValue")
      }
      return ArticlePreviewFragmentArgs(__article)
    }
  }
}
