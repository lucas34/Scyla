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

package kit.scyla.canvas.facets.image;


import kit.scyla.canvas.shapes.custom.skinned.SkinnedShape;
import kit.scyla.core.facets.image.ImageFacet;

/**
 * Created by Ferrand on 24/12/2014.
 * TODO TODO TODO
 */
public class SkinnedShapeImageFacet<TShape extends SkinnedShape<TShape>> extends ImageFacet<TShape> {
    public SkinnedShapeImageFacet() {
        super();
    }

    @Override
    public TShape createInstance() {
        return null;
    }

    @Override
    public void restore(TShape shape) {

    }
}
