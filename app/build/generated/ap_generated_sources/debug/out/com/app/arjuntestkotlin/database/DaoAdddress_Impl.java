package com.app.arjuntestkotlin.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class DaoAdddress_Impl implements DaoAdddress {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfEntityAddress;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfEntityAddress;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DaoAdddress_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEntityAddress = new EntityInsertionAdapter<EntityAddress>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `address`(`id`,`name`,`from_date`,`to_date`,`coupon_code`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityAddress value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getColorcode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getColorcode());
        }
        if (value.getCoupon_code() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCoupon_code());
        }
      }
    };
    this.__updateAdapterOfEntityAddress = new EntityDeletionOrUpdateAdapter<EntityAddress>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `address` SET `id` = ?,`name` = ?,`from_date` = ?,`to_date` = ?,`coupon_code` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityAddress value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getColorcode() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getColorcode());
        }
        if (value.getCoupon_code() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCoupon_code());
        }
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM address";
        return _query;
      }
    };
  }

  @Override
  public void addNote(EntityAddress note) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfEntityAddress.insert(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateNote(EntityAddress note) {
    __db.beginTransaction();
    try {
      __updateAdapterOfEntityAddress.handle(note);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EntityAddress>> getAllNotes() {
    final String _sql = "SELECT * FROM address";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<EntityAddress>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<EntityAddress> compute() {
        if (_observer == null) {
          _observer = new Observer("address") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("from_date");
          final int _cursorIndexOfColorcode = _cursor.getColumnIndexOrThrow("to_date");
          final int _cursorIndexOfCouponCode = _cursor.getColumnIndexOrThrow("coupon_code");
          final List<EntityAddress> _result = new ArrayList<EntityAddress>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EntityAddress _item;
            _item = new EntityAddress();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _item.setName(_tmpName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _item.setDescription(_tmpDescription);
            final String _tmpColorcode;
            _tmpColorcode = _cursor.getString(_cursorIndexOfColorcode);
            _item.setColorcode(_tmpColorcode);
            final String _tmpCoupon_code;
            _tmpCoupon_code = _cursor.getString(_cursorIndexOfCouponCode);
            _item.setCoupon_code(_tmpCoupon_code);
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
    }.getLiveData();
  }
}
