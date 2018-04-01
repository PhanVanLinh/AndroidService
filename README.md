# AndroidUnBoundService

https://phanvanlinh.github.io/posts/android/android-service.html

### Life cycle
#### startService(...)
`onCreate()`
`onStartCommand`
#### stopService(...) or stopSelf or kill service in Setting->Running service
`onDestroy`
#### Open another activity or go to background (presshome, pressback)
`NOTHING CALL`
#### Kill process (kill app in Recent App)
**START_STICKY**
`onCreate()`
`onStartCommand`
**START_NOT_STICKY**
`NOTHING CALL`

### onDestroy
For unbound service, if we use `START_STICKY` or `START_NOT_STICKY`
On destroy **WILL NOT CALL** when we kill process (kill app in Recent app)
On destroy **WILL CALL** when we kill service from Setting->Running process or when we kill it by `stopSelf` or `stopService(...)`

