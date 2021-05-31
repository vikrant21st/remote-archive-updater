package jetbrains.compose.classfileupdator.utils

import java.io.File

fun <T> List<T>.divideIn(noOfSubLists: Int): List<List<T>> {
    if (size <= noOfSubLists)
        return map { listOf(it) }

    val minBucketSize = (size / noOfSubLists)
    val bucketsWithExtra = size % noOfSubLists
    var startIndex = 0
    return (0 until noOfSubLists)
        .map { index ->
            val extra =
                if (index < bucketsWithExtra) 1
                else 0
            val newStartIndex = startIndex + minBucketSize + extra
            val list = subList(startIndex, newStartIndex)
            startIndex = newStartIndex
            list
        }
}

fun addFileSeparatorSuffix(path: String, separator: Char = File.separatorChar) =
    if (path.endsWith(separator))
        path
    else
        "$path$separator"
