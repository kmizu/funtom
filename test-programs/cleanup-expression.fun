mutable i = 0
def loop() =
  while(i < 10) {
    i = i + 1
  } cleanup {
    println(i)
  }
