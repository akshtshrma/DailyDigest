package com.androiddevs.mvvmnewsapp.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.androiddevs.mvvmnewsapp.models.Article;
import com.androiddevs.mvvmnewsapp.models.Source;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ArticleDAO_Impl implements ArticleDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Article> __insertionAdapterOfArticle;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Article> __deletionAdapterOfArticle;

  public ArticleDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArticle = new EntityInsertionAdapter<Article>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `articles` (`id`,`author`,`content`,`description`,`publishedAt`,`source`,`title`,`url`,`urlToImage`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Article entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAuthor());
        }
        if (entity.getContent() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContent());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        if (entity.getPublishedAt() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPublishedAt());
        }
        final String _tmp = __converters.fromSource(entity.getSource());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        if (entity.getTitle() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTitle());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getUrl());
        }
        if (entity.getUrlToImage() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUrlToImage());
        }
      }
    };
    this.__deletionAdapterOfArticle = new EntityDeletionOrUpdateAdapter<Article>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `articles` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Article entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
      }
    };
  }

  @Override
  public long upsert(final Article article) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfArticle.insertAndReturnId(article);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteArticle(final Article article) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfArticle.handle(article);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Article>> getAllArticles() {
    final String _sql = "SELECT * FROM articles";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"articles"}, false, new Callable<List<Article>>() {
      @Override
      @Nullable
      public List<Article> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final List<Article> _result = new ArrayList<Article>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Article _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpPublishedAt;
            if (_cursor.isNull(_cursorIndexOfPublishedAt)) {
              _tmpPublishedAt = null;
            } else {
              _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            }
            final Source _tmpSource;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfSource)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfSource);
            }
            _tmpSource = __converters.toSource(_tmp);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpUrlToImage;
            if (_cursor.isNull(_cursorIndexOfUrlToImage)) {
              _tmpUrlToImage = null;
            } else {
              _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            }
            _item = new Article(_tmpId,_tmpAuthor,_tmpContent,_tmpDescription,_tmpPublishedAt,_tmpSource,_tmpTitle,_tmpUrl,_tmpUrlToImage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
