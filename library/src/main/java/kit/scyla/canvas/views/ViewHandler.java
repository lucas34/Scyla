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

package kit.scyla.canvas.views;

import android.content.Context;

import java.lang.reflect.Constructor;

import kit.scyla.canvas.render.Scene;
import kit.scyla.core.ScylaView;
import rx.functions.Action0;

/**
 * Created with IntelliJ
 * Created by Ferrand
 * Date 29/11/2014
 */
@SuppressWarnings({"unused", "unchecked"})
public abstract class ViewHandler {
    private final Scene m_scene;
    private final Context m_context;
    private ScylaView m_current;

    public ViewHandler(Context context, Scene scene) {
        this.m_context = context;
        this.m_scene = scene;
        this.m_current = bootstrap(this);
    }

    public final ScylaView getCurrent() {
        return m_current;
    }

    public void setCurrent(final Class<? extends ScylaCanvasView> viewClass) {
        if (m_scene.isPaused()) {
            try {
                Constructor<? extends ScylaCanvasView> constructor = viewClass.getConstructor(ViewHandler.class, Context.class);
                m_current = constructor.newInstance(ViewHandler.this, m_context);
                onNext();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } else {
            m_scene.subscribeRuntimeAction(new Action0() {
                @Override
                public void call() {

                    if (viewClass == null) {
                        return;
                    }

                    try {
                        Constructor<? extends ScylaCanvasView> constructor = viewClass.getConstructor(ViewHandler.class, Context.class);
                        m_current = constructor.newInstance(ViewHandler.this, m_context);
                        onNext();
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }

                }
            });
        }
    }

    public void setCurrent(final ScylaView view) {
        if (m_scene.isPaused()) {
            m_current = view;
            onNext();
        } else {
            m_scene.subscribeRuntimeAction(new Action0() {
                @Override
                public void call() {

                    if (view == null) {
                        return;
                    }

                    m_current = view;
                    onNext();
                }
            });
        }
    }

    public final void load(ScylaView stage) {
        m_current = stage;
        onNext();
    }

    public final void reload() {
        onNext();
    }

    public abstract void onNext();

    public Scene scene() {
        return m_scene;
    }

    public Context context() {
        return m_context;
    }

    public abstract ScylaView bootstrap(ViewHandler handler);

}
