package com.plcoding.bookpedia.book.`data`.database

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.EntityUpsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class FavoriteBookDao_Impl(
  __db: RoomDatabase,
) : FavoriteBookDao {
  private val __db: RoomDatabase

  private val __upsertAdapterOfBookEntity: EntityUpsertAdapter<BookEntity>
  init {
    this.__db = __db
    this.__upsertAdapterOfBookEntity = EntityUpsertAdapter<BookEntity>(object :
        EntityInsertAdapter<BookEntity>() {
      protected override fun createQuery(): String =
          "INSERT INTO `BookEntity` (`id`,`title`,`description`,`imageUrl`,`languages`,`authors`,`firstPublishYear`,`ratingsAverage`,`ratingsCount`,`numPagesMedian`,`numEditions`) VALUES (?,?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: BookEntity) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.title)
        val _tmpDescription: String? = entity.description
        if (_tmpDescription == null) {
          statement.bindNull(3)
        } else {
          statement.bindText(3, _tmpDescription)
        }
        statement.bindText(4, entity.imageUrl)
        val _tmp: String = StringListTypeConverter.fromList(entity.languages)
        statement.bindText(5, _tmp)
        val _tmp_1: String = StringListTypeConverter.fromList(entity.authors)
        statement.bindText(6, _tmp_1)
        val _tmpFirstPublishYear: String? = entity.firstPublishYear
        if (_tmpFirstPublishYear == null) {
          statement.bindNull(7)
        } else {
          statement.bindText(7, _tmpFirstPublishYear)
        }
        val _tmpRatingsAverage: Double? = entity.ratingsAverage
        if (_tmpRatingsAverage == null) {
          statement.bindNull(8)
        } else {
          statement.bindDouble(8, _tmpRatingsAverage)
        }
        val _tmpRatingsCount: Int? = entity.ratingsCount
        if (_tmpRatingsCount == null) {
          statement.bindNull(9)
        } else {
          statement.bindLong(9, _tmpRatingsCount.toLong())
        }
        val _tmpNumPagesMedian: Int? = entity.numPagesMedian
        if (_tmpNumPagesMedian == null) {
          statement.bindNull(10)
        } else {
          statement.bindLong(10, _tmpNumPagesMedian.toLong())
        }
        statement.bindLong(11, entity.numEditions.toLong())
      }
    }, object : EntityDeleteOrUpdateAdapter<BookEntity>() {
      protected override fun createQuery(): String =
          "UPDATE `BookEntity` SET `id` = ?,`title` = ?,`description` = ?,`imageUrl` = ?,`languages` = ?,`authors` = ?,`firstPublishYear` = ?,`ratingsAverage` = ?,`ratingsCount` = ?,`numPagesMedian` = ?,`numEditions` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: BookEntity) {
        statement.bindText(1, entity.id)
        statement.bindText(2, entity.title)
        val _tmpDescription: String? = entity.description
        if (_tmpDescription == null) {
          statement.bindNull(3)
        } else {
          statement.bindText(3, _tmpDescription)
        }
        statement.bindText(4, entity.imageUrl)
        val _tmp: String = StringListTypeConverter.fromList(entity.languages)
        statement.bindText(5, _tmp)
        val _tmp_1: String = StringListTypeConverter.fromList(entity.authors)
        statement.bindText(6, _tmp_1)
        val _tmpFirstPublishYear: String? = entity.firstPublishYear
        if (_tmpFirstPublishYear == null) {
          statement.bindNull(7)
        } else {
          statement.bindText(7, _tmpFirstPublishYear)
        }
        val _tmpRatingsAverage: Double? = entity.ratingsAverage
        if (_tmpRatingsAverage == null) {
          statement.bindNull(8)
        } else {
          statement.bindDouble(8, _tmpRatingsAverage)
        }
        val _tmpRatingsCount: Int? = entity.ratingsCount
        if (_tmpRatingsCount == null) {
          statement.bindNull(9)
        } else {
          statement.bindLong(9, _tmpRatingsCount.toLong())
        }
        val _tmpNumPagesMedian: Int? = entity.numPagesMedian
        if (_tmpNumPagesMedian == null) {
          statement.bindNull(10)
        } else {
          statement.bindLong(10, _tmpNumPagesMedian.toLong())
        }
        statement.bindLong(11, entity.numEditions.toLong())
        statement.bindText(12, entity.id)
      }
    })
  }

  public override suspend fun upsert(book: BookEntity): Unit = performSuspending(__db, false, true)
      { _connection ->
    __upsertAdapterOfBookEntity.upsert(_connection, book)
  }

  public override fun getFavoriteBooks(): Flow<List<BookEntity>> {
    val _sql: String = "SELECT * FROM BookEntity"
    return createFlow(__db, false, arrayOf("BookEntity")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _cursorIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _cursorIndexOfLanguages: Int = getColumnIndexOrThrow(_stmt, "languages")
        val _cursorIndexOfAuthors: Int = getColumnIndexOrThrow(_stmt, "authors")
        val _cursorIndexOfFirstPublishYear: Int = getColumnIndexOrThrow(_stmt, "firstPublishYear")
        val _cursorIndexOfRatingsAverage: Int = getColumnIndexOrThrow(_stmt, "ratingsAverage")
        val _cursorIndexOfRatingsCount: Int = getColumnIndexOrThrow(_stmt, "ratingsCount")
        val _cursorIndexOfNumPagesMedian: Int = getColumnIndexOrThrow(_stmt, "numPagesMedian")
        val _cursorIndexOfNumEditions: Int = getColumnIndexOrThrow(_stmt, "numEditions")
        val _result: MutableList<BookEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: BookEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpDescription: String?
          if (_stmt.isNull(_cursorIndexOfDescription)) {
            _tmpDescription = null
          } else {
            _tmpDescription = _stmt.getText(_cursorIndexOfDescription)
          }
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_cursorIndexOfImageUrl)
          val _tmpLanguages: List<String>
          val _tmp: String
          _tmp = _stmt.getText(_cursorIndexOfLanguages)
          _tmpLanguages = StringListTypeConverter.fromString(_tmp)
          val _tmpAuthors: List<String>
          val _tmp_1: String
          _tmp_1 = _stmt.getText(_cursorIndexOfAuthors)
          _tmpAuthors = StringListTypeConverter.fromString(_tmp_1)
          val _tmpFirstPublishYear: String?
          if (_stmt.isNull(_cursorIndexOfFirstPublishYear)) {
            _tmpFirstPublishYear = null
          } else {
            _tmpFirstPublishYear = _stmt.getText(_cursorIndexOfFirstPublishYear)
          }
          val _tmpRatingsAverage: Double?
          if (_stmt.isNull(_cursorIndexOfRatingsAverage)) {
            _tmpRatingsAverage = null
          } else {
            _tmpRatingsAverage = _stmt.getDouble(_cursorIndexOfRatingsAverage)
          }
          val _tmpRatingsCount: Int?
          if (_stmt.isNull(_cursorIndexOfRatingsCount)) {
            _tmpRatingsCount = null
          } else {
            _tmpRatingsCount = _stmt.getLong(_cursorIndexOfRatingsCount).toInt()
          }
          val _tmpNumPagesMedian: Int?
          if (_stmt.isNull(_cursorIndexOfNumPagesMedian)) {
            _tmpNumPagesMedian = null
          } else {
            _tmpNumPagesMedian = _stmt.getLong(_cursorIndexOfNumPagesMedian).toInt()
          }
          val _tmpNumEditions: Int
          _tmpNumEditions = _stmt.getLong(_cursorIndexOfNumEditions).toInt()
          _item =
              BookEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpLanguages,_tmpAuthors,_tmpFirstPublishYear,_tmpRatingsAverage,_tmpRatingsCount,_tmpNumPagesMedian,_tmpNumEditions)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getFavoriteBook(id: String): BookEntity? {
    val _sql: String = "SELECT * FROM BookEntity WHERE id = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfTitle: Int = getColumnIndexOrThrow(_stmt, "title")
        val _cursorIndexOfDescription: Int = getColumnIndexOrThrow(_stmt, "description")
        val _cursorIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _cursorIndexOfLanguages: Int = getColumnIndexOrThrow(_stmt, "languages")
        val _cursorIndexOfAuthors: Int = getColumnIndexOrThrow(_stmt, "authors")
        val _cursorIndexOfFirstPublishYear: Int = getColumnIndexOrThrow(_stmt, "firstPublishYear")
        val _cursorIndexOfRatingsAverage: Int = getColumnIndexOrThrow(_stmt, "ratingsAverage")
        val _cursorIndexOfRatingsCount: Int = getColumnIndexOrThrow(_stmt, "ratingsCount")
        val _cursorIndexOfNumPagesMedian: Int = getColumnIndexOrThrow(_stmt, "numPagesMedian")
        val _cursorIndexOfNumEditions: Int = getColumnIndexOrThrow(_stmt, "numEditions")
        val _result: BookEntity?
        if (_stmt.step()) {
          val _tmpId: String
          _tmpId = _stmt.getText(_cursorIndexOfId)
          val _tmpTitle: String
          _tmpTitle = _stmt.getText(_cursorIndexOfTitle)
          val _tmpDescription: String?
          if (_stmt.isNull(_cursorIndexOfDescription)) {
            _tmpDescription = null
          } else {
            _tmpDescription = _stmt.getText(_cursorIndexOfDescription)
          }
          val _tmpImageUrl: String
          _tmpImageUrl = _stmt.getText(_cursorIndexOfImageUrl)
          val _tmpLanguages: List<String>
          val _tmp: String
          _tmp = _stmt.getText(_cursorIndexOfLanguages)
          _tmpLanguages = StringListTypeConverter.fromString(_tmp)
          val _tmpAuthors: List<String>
          val _tmp_1: String
          _tmp_1 = _stmt.getText(_cursorIndexOfAuthors)
          _tmpAuthors = StringListTypeConverter.fromString(_tmp_1)
          val _tmpFirstPublishYear: String?
          if (_stmt.isNull(_cursorIndexOfFirstPublishYear)) {
            _tmpFirstPublishYear = null
          } else {
            _tmpFirstPublishYear = _stmt.getText(_cursorIndexOfFirstPublishYear)
          }
          val _tmpRatingsAverage: Double?
          if (_stmt.isNull(_cursorIndexOfRatingsAverage)) {
            _tmpRatingsAverage = null
          } else {
            _tmpRatingsAverage = _stmt.getDouble(_cursorIndexOfRatingsAverage)
          }
          val _tmpRatingsCount: Int?
          if (_stmt.isNull(_cursorIndexOfRatingsCount)) {
            _tmpRatingsCount = null
          } else {
            _tmpRatingsCount = _stmt.getLong(_cursorIndexOfRatingsCount).toInt()
          }
          val _tmpNumPagesMedian: Int?
          if (_stmt.isNull(_cursorIndexOfNumPagesMedian)) {
            _tmpNumPagesMedian = null
          } else {
            _tmpNumPagesMedian = _stmt.getLong(_cursorIndexOfNumPagesMedian).toInt()
          }
          val _tmpNumEditions: Int
          _tmpNumEditions = _stmt.getLong(_cursorIndexOfNumEditions).toInt()
          _result =
              BookEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpImageUrl,_tmpLanguages,_tmpAuthors,_tmpFirstPublishYear,_tmpRatingsAverage,_tmpRatingsCount,_tmpNumPagesMedian,_tmpNumEditions)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun deleteFavoriteBook(id: String) {
    val _sql: String = "DELETE FROM BookEntity WHERE id = ?"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, id)
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
