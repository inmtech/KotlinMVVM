package com.app.arjuntestkotlin.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class MyAppDatabase_Impl extends MyAppDatabase {
  private volatile DaoAdddress _daoAdddress;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `address` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `from_date` TEXT, `to_date` TEXT, `coupon_code` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"a4e55df09a01721ed27ccb29b6b4eb4f\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `address`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAddress = new HashMap<String, TableInfo.Column>(5);
        _columnsAddress.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsAddress.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsAddress.put("from_date", new TableInfo.Column("from_date", "TEXT", false, 0));
        _columnsAddress.put("to_date", new TableInfo.Column("to_date", "TEXT", false, 0));
        _columnsAddress.put("coupon_code", new TableInfo.Column("coupon_code", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddress = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddress = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddress = new TableInfo("address", _columnsAddress, _foreignKeysAddress, _indicesAddress);
        final TableInfo _existingAddress = TableInfo.read(_db, "address");
        if (! _infoAddress.equals(_existingAddress)) {
          throw new IllegalStateException("Migration didn't properly handle address(com.app.arjuntestkotlin.database.EntityAddress).\n"
                  + " Expected:\n" + _infoAddress + "\n"
                  + " Found:\n" + _existingAddress);
        }
      }
    }, "a4e55df09a01721ed27ccb29b6b4eb4f", "7a8e8bf8e05bf2e824eb0324ab262594");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "address");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `address`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DaoAdddress daoAdddress() {
    if (_daoAdddress != null) {
      return _daoAdddress;
    } else {
      synchronized(this) {
        if(_daoAdddress == null) {
          _daoAdddress = new DaoAdddress_Impl(this);
        }
        return _daoAdddress;
      }
    }
  }
}
