var Instant = Java.type('java.time.Instant');
var ChronoUnit = Java.type('java.time.temporal.ChronoUnit');
print('Now: ' + Instant.now());
var nowPlus30Days = Instant.now().plus(30, ChronoUnit.DAYS);
print('Now +30 days:' + nowPlus30Days);