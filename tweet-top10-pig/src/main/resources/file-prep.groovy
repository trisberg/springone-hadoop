//requires three variables, localSourceFile and inputDir, outputDir 

// use the shell (made available under variable fsh)

if (fsh.test(outputDir)) {
   fsh.rmr(outputDir)
}
