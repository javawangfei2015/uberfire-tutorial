/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.client.screens.popup;

import org.uberfire.client.screens.TasksPresenter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class NewFolderPresenter {

    public interface View {

        void show();

        void hide();

        void init( NewFolderPresenter presenter );
    }

    @Inject
    private View view;

    private TasksPresenter tasksPresenter;

    @PostConstruct
    public void setup() {
        view.init( this );
    }

    public void show( TasksPresenter tasksPresenter ) {
        this.tasksPresenter = tasksPresenter;
        view.show();
    }

    public void newFolder( String folderName ) {
        tasksPresenter.newFolder( folderName );
        view.hide();
    }

    public void close() {
        view.hide();
    }
}