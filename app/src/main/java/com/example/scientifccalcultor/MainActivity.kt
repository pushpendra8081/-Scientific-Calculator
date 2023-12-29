package com.example.scientifccalcultor

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression


class MainActivity : AppCompatActivity() {

    private lateinit var previousCal:TextView
    private lateinit var display:EditText

    var isPortrait = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)
        previousCal = findViewById(R.id.previCal)
        display.showSoftInputOnFocus = false


    }

    private fun updateText(strToAdd:String){

        val oldStr = display.text.toString()
        val cursorPs = display.selectionStart
        val leftStr = oldStr.substring(0,cursorPs)
        val rightStr = oldStr.substring(cursorPs)
        display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr))
        display.setSelection(cursorPs + strToAdd.length)
    }





    fun equalsBtn(view: View) {
        var userExp = display.text.toString()
        previousCal.text = userExp
        userExp = userExp.replace(resources.getString(R.string.divideText).toRegex(), "/")
        userExp = userExp.replace(resources.getString(R.string.multiplyText).toRegex(), "*")
        val exp = Expression(userExp)
        val result = exp.calculate().toString()
        display.setText(result)
        display.setSelection(result.length)
    }
    fun decimalBtn(view: View) {
        updateText(resources.getString(R.string.decimalText))
    }
    fun zeroBtn(view: View) {
        updateText(resources.getString(R.string.zeroText))
    }
    fun absBtn(view: View) {
        updateText("abs(")
    }
    fun piBtn(view: View) {
        updateText("pi")
    }
    fun eBtn(view: View) {
        updateText("e")
    }
    fun addBtn(view: View) {
        updateText(resources.getString(R.string.addText))
    }
    fun threeBtn(view: View) {
        updateText(resources.getString(R.string.threeText))
    }
    fun twoBtn(view: View) {
        updateText(resources.getString(R.string.twoText))
    }
    fun oneBtn(view: View) {
        updateText(resources.getString(R.string.oneText))
    }
    fun sqrtBtn(view: View) {
        updateText("sqrt(")
    }
    fun naturalLogBtn(view: View) {
        updateText("ln(")
    }
    fun logBtn(view: View) {
        updateText("log(")
    }
    fun subtractBtn(view: View) {
        updateText(resources.getString(R.string.subtractText))
    }
    fun sixBtn(view: View) {
        updateText(resources.getString(R.string.sixText))
    }
    fun fiveBtn(view: View) {
        updateText(resources.getString(R.string.fiveText))
    }
    fun foureBtn(view: View) {
        updateText(resources.getString(R.string.fourText))
    }
    fun trigArcTanBtn(view: View) {
        updateText("arctan()")
    }
    fun trigArcCosBtn(view: View) {
        updateText("arccos(")
    }
    fun trigArcSinBtn(view: View) {
        updateText("arcsin(")
    }
    fun multiplyBtn(view: View) {
        updateText(resources.getString(R.string.multiplyText))
    }
    fun nineBtn(view: View) {
        updateText(resources.getString(R.string.nineText))
    }
    fun eightBtn(view: View) {
        updateText(resources.getString(R.string.eightText))
    }
    fun sevenBtn(view: View) {
        updateText(resources.getString(R.string.sevenText))
    }
    fun trigtanBtn(view: View) {
        updateText("tan(")
    }
    fun trigCosBtn(view: View) {
        updateText("cos(")
    }
    fun trigSinBtn(view: View) {
        updateText("sin(")
    }
    fun divideBtn(view: View) {
        updateText(resources.getString(R.string.divideText))
    }
    fun parcloseBtn(view: View) {
        updateText(resources.getString(R.string.parenthesesCloseText))
    }
    fun parOpenBtn(view: View) {
        updateText(resources.getString(R.string.parenthesesOpenText))
    }
    fun clearBtn(view: View) {
        display.setText("")
        previousCal.text = ""
    }
    fun xPowerYBtn(view: View) {
        updateText("^(")
    }
    fun xSquaredBtn(view: View) {
        updateText("^(2)")
    }
    fun primeBtn(view: View) {
        updateText("isprc(")
    }
    fun backSpaceBtn(view: View) {
        val cursorPos = display.selectionStart
        val textLen = display.text.length
        if (cursorPos != 0 && textLen != 0){
            val selection = display.text as SpannableStringBuilder
            selection.replace(cursorPos -1,cursorPos,"")
            display.text = selection
            display.setSelection(cursorPos -1)
        }
    }
    fun rotateBtn(view: View) {
        requestedOrientation = if (isPortrait){
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
        }
        else{
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
        }
        isPortrait = !isPortrait
    }

}