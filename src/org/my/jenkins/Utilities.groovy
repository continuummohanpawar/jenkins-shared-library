package org.my.jenkins

class Utilities implements Serializable{
  static def mvn(script, args) {
    println("${args}")
  }
}