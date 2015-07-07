package com.github.dockerjava.core.command;

import static com.google.common.base.Preconditions.checkNotNull;

import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.AttachContainerCmd;
import com.github.dockerjava.api.model.Frame;

/**
 * Attach to container
 *
 * @param logs
 *            - true or false, includes logs. Defaults to false.
 *
 * @param followStream
 *            - true or false, return stream. Defaults to false.
 * @param stdout
 *            - true or false, includes stdout log. Defaults to false.
 * @param stderr
 *            - true or false, includes stderr log. Defaults to false.
 * @param timestamps
 *            - true or false, if true, print timestamps for every log line. Defaults to false.
 */
public class AttachContainerCmdImpl extends AbstrDockerCmd<AttachContainerCmd, Void> implements AttachContainerCmd {

    private ResultCallback<Frame> resultCallback;

    private String containerId;

    private boolean logs, followStream, timestamps, stdout, stderr;

    public AttachContainerCmdImpl(AttachContainerCmd.Exec exec, String containerId, ResultCallback<Frame> resultCallback) {
        super(exec);
        withContainerId(containerId);
        withResultCallback(resultCallback);
    }

    public ResultCallback<Frame> getResultCallback() {
        return resultCallback;
    }

    @Override
    public AttachContainerCmd withResultCallback(ResultCallback<Frame> resultCallback) {
        checkNotNull(resultCallback, "resultCallback was not specified");
        this.resultCallback = resultCallback;
        return this;
    }

    @Override
    public String getContainerId() {
        return containerId;
    }

    @Override
    public boolean hasLogsEnabled() {
        return logs;
    }

    @Override
    public boolean hasFollowStreamEnabled() {
        return followStream;
    }

    @Override
    public boolean hasTimestampsEnabled() {
        return timestamps;
    }

    @Override
    public boolean hasStdoutEnabled() {
        return stdout;
    }

    @Override
    public boolean hasStderrEnabled() {
        return stderr;
    }

    @Override
    public AttachContainerCmd withContainerId(String containerId) {
        checkNotNull(containerId, "containerId was not specified");
        this.containerId = containerId;
        return this;
    }

    @Override
    public AttachContainerCmd withFollowStream() {
        return withFollowStream(true);
    }

    @Override
    public AttachContainerCmd withFollowStream(boolean followStream) {
        this.followStream = followStream;
        return this;
    }

    @Override
    public AttachContainerCmd withTimestamps(boolean timestamps) {
        this.timestamps = timestamps;
        return this;
    }

    @Override
    public AttachContainerCmd withStdOut() {
        return withStdOut(true);
    }

    @Override
    public AttachContainerCmd withStdOut(boolean stdout) {
        this.stdout = stdout;
        return this;
    }

    @Override
    public AttachContainerCmd withStdErr() {
        return withStdErr(true);
    }

    @Override
    public AttachContainerCmd withStdErr(boolean stderr) {
        this.stderr = stderr;
        return this;
    }

    @Override
    public AttachContainerCmd withLogs(boolean logs) {
        this.logs = logs;
        return this;
    }

    @Override
    public AttachContainerCmd withLogs() {
        return withLogs(true);
    }

    /**
     * @throws NotFoundException
     *             No such container
     */
    @Override
    public Void exec() throws NotFoundException {
        return super.exec();
    }
}
