/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive_grid_cloud_portal.scheduler.client.view.grid.tasks;

import org.ow2.proactive_grid_cloud_portal.scheduler.client.Task;
import org.ow2.proactive_grid_cloud_portal.scheduler.client.view.grid.GridColumns;

import com.smartgwt.client.data.Record;


/**
 * The factory to get the columns specifications, and build record acoording to this specification, for a task-centric grid.
 *
 * @author the activeeon team.
 */
public class TasksCentricColumnsFactory extends TasksColumnsFactory {

    public static final GridColumns JOB_ID_ATTR = new GridColumns("jobId", "Job Id", 80, true, true);

    public static final GridColumns JOB_NAME_ATTR = new GridColumns("jobName", "Job Name", 120, true, false);

    private static final GridColumns[] COLUMNS = new GridColumns[] { ID_ATTR, STATUS_ATTR, NAME_ATTR, TAG_ATTR,
                                                                     JOB_ID_ATTR, JOB_NAME_ATTR, EXEC_DURATION_ATTR,
                                                                     NODE_COUNT_ATTR, EXECUTIONS_ATTR,
                                                                     NODE_FAILURE_ATTR, HOST_ATTR, START_TIME_ATTR,
                                                                     FINISHED_TIME_ATTR, NEXT_TIME_ATTR,
                                                                     DESCRIPTION_ATTR };

    protected static final GridColumns[] COLUMNS_TO_ALIGN = new GridColumns[] { ID_ATTR, STATUS_ATTR, NAME_ATTR,
                                                                                TAG_ATTR, JOB_ID_ATTR, JOB_NAME_ATTR,
                                                                                EXEC_DURATION_ATTR, NODE_COUNT_ATTR,
                                                                                EXECUTIONS_ATTR, NODE_FAILURE_ATTR,
                                                                                HOST_ATTR, START_TIME_ATTR,
                                                                                FINISHED_TIME_ATTR, NEXT_TIME_ATTR };

    @Override
    public GridColumns[] getColumns() {
        return COLUMNS;
    }

    @Override
    public void buildRecord(Task item, Record record) {
        super.buildRecord(item, record);
        buildDetailsColumns(record, item);
        record.setAttribute(JOB_ID_ATTR.getName(), item.getJobId());
        record.setAttribute(JOB_NAME_ATTR.getName(), item.getJobName());
    }

}
