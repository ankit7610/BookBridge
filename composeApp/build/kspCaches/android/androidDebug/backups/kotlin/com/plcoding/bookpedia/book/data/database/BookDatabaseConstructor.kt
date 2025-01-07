package com.plcoding.bookpedia.book.`data`.database

import androidx.room.RoomDatabaseConstructor

public actual object BookDatabaseConstructor : RoomDatabaseConstructor<FavoriteBookDatabase> {
  actual override fun initialize(): FavoriteBookDatabase =
      com.plcoding.bookpedia.book.`data`.database.FavoriteBookDatabase_Impl()
}
