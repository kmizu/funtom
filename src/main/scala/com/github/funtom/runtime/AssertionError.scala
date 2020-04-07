package com.github.funtom.runtime

case class AssertionError(message: String) extends Error(message)