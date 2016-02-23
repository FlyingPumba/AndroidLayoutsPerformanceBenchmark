#Android Layout performance benchmark

##Environment:

- Device: Moto G LTE 1st Gen
- Power cord connected
- No "recent" apps when starting benchmark

##Measurement:

- Set start time in milliseconds at the very beginning of `onCreate` method.
- Call `setContentView` method, passing the view generated programmatically or the resource identifier.
- Set end time in milliseconds at the end of `onResume` method.
- Load time is the difference between end and start time.

##Results:

The results are the average of 5 runs.

- LinearLayout (Vertical) with 5000 TextViews:

-- XML: 3928 ms.
-- Java: 2908 ms.
