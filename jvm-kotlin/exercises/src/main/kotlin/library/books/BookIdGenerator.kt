package library.books

import library.books.domain.types.BookId
import org.springframework.stereotype.Component

@Component
class BookIdGenerator(
    private val dataStore: BookDataStore
) {

    fun generate(): BookId {
        var bookId = BookId.generate()
        if (dataStore.existsById(bookId)) {
            bookId = generate()
        }
        return bookId
    }

}
