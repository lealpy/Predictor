package com.lealpy.predictor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {

    private val _prediction = MutableLiveData<String>()
    val prediction : LiveData<String> = _prediction

    private var clickCounter = 0

    private val _clickCounterText = MutableLiveData<String>()
    val clickCounterText : LiveData<String> = _clickCounterText

    private val firstPhrase = listOf(
        "Вам нужно ",
        "Советую вам ",
        "Это будет страшной ошибкой - ",
        "Нужно немедленно ",
        "Это очень рискованно - ",
        "Невозможно ",
        "Лучше всего тайком ",
        "Чувствую, что вы хотите ",
        "Вы сами знаете, что следует ",
        "Повелеваю "
        )

    private val secondPhrase = listOf(
        "заняться этим прямо сейчас.",
        "ещё раз всё обдумать.",
        "предусмотреть путь для отступления.",
        "прыгнуть в омут с головой.",
        "поторопиться с принятием решения.",
        "забыть об этом.",
        "сделать, но никому не рассказывать.",
        "рассказать об этом другу и послушать его совета.",
        "послушать меня и сделать наоборот.",
        "перестать спрашивать у бесполезного меня и принять решение самостоятельно. В КОИ-ТО ВЕКИ!"
    )

    fun onBtnClicked() {
        clickCounter ++
        _clickCounterText.value = "Получено предсказаний: $clickCounter"
        generatePhrase()
    }

    private fun generatePhrase() {
        val random = Random()
        val indexOfFirstPhrase = random.nextInt(firstPhrase.lastIndex)
        val indexOfSecondPhrase = random.nextInt(secondPhrase.lastIndex)
        _prediction.value = firstPhrase[indexOfFirstPhrase] + secondPhrase[indexOfSecondPhrase]
    }

}