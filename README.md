# AndroidService


| Unbound Service | Bound Service | Intent Service   |
| :------- | ----: | :---: |
|**Unbounded Service** use to make a task for long time and repeat. | **Bounded Service** được sử dụng để thực hiện nhiệm vụ ở nền (background) và ràng buộc với thành phần giao diện. |  **Intent Service** được sử dụng để thực hiện các nhiệm vụ một lần duy nhất, nghĩa là khi nhiệm vụ hoàn thành dịch vụ tự hủy.|
|start by `startService()`.| start by `bindService()`.|start by `startService()`.|
|stop by `stopService()`.|Bounded Service bị gỡ giàng buộc hoặc bị hủy bởi gọi unbindService().|  stop by `stopself()`|
|**independent** with the component started it.| **dependent** with the component started it.| **independent** with the component started it.  |