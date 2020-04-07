package com.github.funtom.runtime


import com.github.funtom.{SourceLocation, TypedAst, Value}

case class PhantomCallError(phantomId: TypedAst.PhantomId, params: Seq[Value]) extends Error(
  {
    val location = phantomId.location.asInstanceOf[SourceLocation]
    s"Phantom ${phantomId.name}(${params.mkString(", ")}) is called: ${location.line}, ${location.column}"
  }

) {
  override def fillInStackTrace(): Throwable = this
}
