package com.plcoding.bookpedia.book.`data`.database

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class FavoriteBookDatabase_Impl : FavoriteBookDatabase() {
  private val _favoriteBookDao: Lazy<FavoriteBookDao> = lazy {
    FavoriteBookDao_Impl(this)
  }


  public override val favoriteBookDao: FavoriteBookDao
    get() = _favoriteBookDao.value

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1,
        "958b0d18d970cb6c02593f62db73f3e4", "124b47974050f123548c305b4d2173c3") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `BookEntity` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `description` TEXT, `imageUrl` TEXT NOT NULL, `languages` TEXT NOT NULL, `authors` TEXT NOT NULL, `firstPublishYear` TEXT, `ratingsAverage` REAL, `ratingsCount` INTEGER, `numPagesMedian` INTEGER, `numEditions` INTEGER NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '958b0d18d970cb6c02593f62db73f3e4')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `BookEntity`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsBookEntity: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsBookEntity.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("title", TableInfo.Column("title", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("description", TableInfo.Column("description", "TEXT", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("imageUrl", TableInfo.Column("imageUrl", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("languages", TableInfo.Column("languages", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("authors", TableInfo.Column("authors", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("firstPublishYear", TableInfo.Column("firstPublishYear", "TEXT",
            false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("ratingsAverage", TableInfo.Column("ratingsAverage", "REAL", false,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("ratingsCount", TableInfo.Column("ratingsCount", "INTEGER", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("numPagesMedian", TableInfo.Column("numPagesMedian", "INTEGER",
            false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsBookEntity.put("numEditions", TableInfo.Column("numEditions", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysBookEntity: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesBookEntity: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoBookEntity: TableInfo = TableInfo("BookEntity", _columnsBookEntity,
            _foreignKeysBookEntity, _indicesBookEntity)
        val _existingBookEntity: TableInfo = read(connection, "BookEntity")
        if (!_infoBookEntity.equals(_existingBookEntity)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |BookEntity(com.plcoding.bookpedia.book.data.database.BookEntity).
              | Expected:
              |""".trimMargin() + _infoBookEntity + """
              |
              | Found:
              |""".trimMargin() + _existingBookEntity)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "BookEntity")
  }

  public override fun clearAllTables() {
    super.performClear(false, "BookEntity")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(FavoriteBookDao::class, FavoriteBookDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }
}
