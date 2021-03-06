/*
 *  Copyright 2015-present Lucas Nelaupe and Ferrand
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package kit.scyla.canvas.touch;

import android.graphics.Point;

import kit.scyla.core.shapes.Shape;

/**
 * Created with IntelliJ
 * Created by Nelaupe Lucas
 * Date 04/01/15
 */
@SuppressWarnings({"unused", "unchecked"})
public interface IGestureEvent {

    void onTouchEvent(Shape shape, Point PointFinger);

    void onMovingEvent(Shape shape, Point PointFinger);

    void onLongPressEvent(Shape shape, Point PointFinger);

    void onDoubleTapEvent(Shape shape, Point PointFinger);

    void onRaiseEvent(Shape shape, Point PointFinger);

}
