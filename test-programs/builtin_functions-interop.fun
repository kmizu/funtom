// url
val url1 = new java.net.URL("https://github.com/kmizu/funtom")
val url2 = url("https://github.com/kmizu/funtom")
println(url2)
assertResult(url1)(url2)

// uri
val uri1 = new java.net.URI("https://github.com/kmizu/funtom")
val uri2 = uri("https://github.com/kmizu/funtom")
println(uri2)
assertResult(uri1)(uri2)

// desktop() -- not supported in Travis CI environment
//val dt = desktop();
//println(dt)
//println(dt->isDesktopSupported())
// dt->mail()
