package com.github.funtom

abstract class Processor[-In, +Out, -Session] {
  def name: String
  def process(input: In, session: Session): Out
}
