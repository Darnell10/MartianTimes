package com.example.martiantimes.model

class MartianTranslator {

    fun martianTranslator(words: String): String? {
        val upperCaseMartian = " Boinga "
        val lowerCaseMartian = " boinga "
        val wordArray = words.split(" ").toTypedArray()
        var result = " "
        for (word in wordArray) {
            result += if (word.length > 3 && Character.isUpperCase(word[0])) {
                upperCaseMartian
            } else if (word.length > 3 && Character.isLowerCase(word[0])) {
                lowerCaseMartian
            } else {
                " $word"
            }
        }
        return result
    }
}