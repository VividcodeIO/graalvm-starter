if (typeof Graal != 'undefined') {
  print('GraalJS version: ' + Graal.versionJS);
  print('GraalVM version: ' + Graal.versionGraalVM);
  print('Is GraalVM runtime: ' + Graal.isGraalRuntime());
} else {
  print('Not running in GraalVM')
}