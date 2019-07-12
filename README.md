OpenEmbedded/Yocto BSP layer for Google Coral Dev Board
=======================================================

**NOTE!** This layer is still an work in progress and this might not be the final location
nor are there any guarantees that I will not rebase the repository before I
consider it complete. If you are interested in this repository please open
a issue to get an status update.

This layer provides support for Coral Dev Board for use with OpenEmbedded
and/or Yocto.

This layer depends on:

    URI: git://git.openembedded.org/openembedded-core
    branch: master
    revision: HEAD

    URI: https://github.com/Freescale/meta-freescale.git
    branch: master
    revision: HEAD

Quick start
-----------

As this layer depends on the Freescale/NXP BSP we can utilize the base setup
from there.

Create directory where you want to store the environment and change the shell
to that location:

    mkdir coral && cd coral

Initialize repo manifest:

    repo init -u https://github.com/Freescale/fsl-community-bsp-platform -b master

Fetch layers in manifest:

    repo sync

Clone `meta-coral`:

    git clone https://github.com/mirzak/meta-coral.git sources/meta-coral

Setup the environment:

    MACHINE=coral-dev DISTRO=fslc-wayland source ./setup-environment build

Add the `meta-coral` layer to bblayers.conf:

    echo 'BBLAYERS += "${BSPDIR}/sources/meta-coral"' >> conf/bblayers.conf

Start baking:

    bitbake core-image-base

Contributing
------------

Please submit any patches against the `meta-coral` using the GitHub
pull-request feature. Fork the repo, make a branch, do the work, rebase
from upstream, create the pull request.

For some useful guidelines to be followed when submitting patches,
please refer to:

- http://openembedded.org/wiki/Commit_Patch_Message_Guidelines

Pull requests will be discussed within the GitHub pull-request
infrastructure. If you want to get informed on new PRs and the
follow-up discussions please use the GitHub's notification system.

Source code:

- https://github.com/mirzak/meta-coral.git
