//

//% hadoop fs -mkdir /tmp
//% hadoop fs -chmod a+w /tmp
//% hadoop fs -mkdir /tweets/hiveout
//% hadoop fs -chmod a+w /tweets/hiveout
// use the shell (made available under variable fsh)
if (!fsh.test("/tmp")) {
  fsh.mkdir("/tmp")
}
fsh.chmod("a+w", "tmp")
if (!fsh.test("/tweets/hiveout")) {
  fsh.mkdir("/tweets/hiveout")
}
fsh.chmod("a+w", "/tweets/hiveout")
