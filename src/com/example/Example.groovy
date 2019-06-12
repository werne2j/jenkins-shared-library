package com.example

class Example {
  def execute(execute) {
    if (!execute) {
      return "Should not execute"
    }
    sh "command"
  }
}
